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
bzt src/test/taurus/end-to-end.yml
```