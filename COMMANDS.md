# jib
Building with jib
```
./gradlew jibDockerBuild -Dhttp.proxyPort=0 -Dhttps.proxyPort=0 --image=agile-springboot:latest
```

# skaffold
```
eval $(minikube env)
skaffold init
skaffold dev
```

# Taurus
```
bzt src/e2e/taurus/end-to-end.yml
```

# Jenkins CI/CD
Jenkins CI/CD is located in examples/jenkins-cicd
```
docker-compose up -d
```