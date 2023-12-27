

docker run -w /src/argocd -v $(pwd):/src registry.k8s.io/kustomize/kustomize:v5.0.0 build