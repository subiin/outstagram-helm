# outstagram-helm
Outstagram 프로젝트에 사용된 Helm 차트의 모음입니다.

주요 디렉토리의 설명입니다.
- outstagram-chart : Outstagram 애플리케이션 배포에 필요한 Kubernetes 리소스를 Helm 차트화한 디렉토리
- sns : outstagram-chart를 각 애플리케이션 서버별로 helm create한 디렉토리
- configmap : Outstagram 애플리케이션 배포에 필요한 ConfigMap을 정의한 디렉토리
- argocd-application : Argocd Application를 정의한 디렉토리
