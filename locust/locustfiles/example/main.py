# -*- coding: utf-8 -*-

from locust import HttpUser, task, between
import random

default_headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36'}


class WebsiteUser(HttpUser):
    wait_time = between(10, 15)

    # On start populate our user list
    def on_start(self):
        self.createUsernames()

    # Create an array of user1 -> user250
    def createUsernames(self):
        self.users = []
        for i in range(250):
            user = "user" + str(i + 1)
            self.users.append(user)
            print(f"Added user: {user}")

    # Fetch the next user in our list
    def getUsername(self):
        return self.users.pop()

    # Login to the site
    def login(self):
        username = self.getUsername()
        loginInformation = {
            "username": username,
            "password":"password"
        }

        self.client.post("/sign-in", loginInformation)

    # Feed request
    def feed(self):
        feed_id = random.randint(4, 750)
        
        url = f"/api/feeds/{feed_id}"

        response = self.client.get(url)

    @task
    def load_page(self):
        # Login first
        self.login()

        # Feed request
        self.feed()
