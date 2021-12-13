* skaffold init --generate-manifests
* skaffold dev --port-forward --cache-artifacts=false
* skaffold delete
* kubectl apply -k .\deployment\overlays\local\ --dry-run=client -o yaml

`kubectl port-forward demo-app-deployment-6fd494776b-7fzbv 5005:5005`
