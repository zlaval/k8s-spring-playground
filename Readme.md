* skaffold init --generate-manifests
* skaffold dev --port-forward --cache-artifacts=false
* skaffold delete
* kubectl apply -k .\deployment\overlays\local\ --dry-run=client -o yaml
* skaffold run -p dev --port-forward --tail

`kubectl port-forward demo-app-deployment-6fd494776b-7fzbv 5005:5005`

#### Harness

* ngrok http 9010
* github oauth
* docker compose harness
* kubectl apply runners
* go ngrok address

#### Vault

* localhost:8200/ui/vault/init
* kubectl exec -it vault-0 -- /bin/sh
* vault login
* vault auth enable kubernetes
* vault secrets enable -path=dev kv-v2
* vault kv put dev/database/config password="admin123"
* vault kv get dev/database/config
* vault write auth/kubernetes/config kubernetes_host="https://$KUBERNETES_PORT_443_TCP_ADDR:443" token_reviewer_jwt="$(cat /var/run/secrets/kubernetes.io/serviceaccount/token)"
  kubernetes_ca_cert=@/var/run/secrets/kubernetes.io/serviceaccount/ca.crt issuer="https://kubernetes.default.svc.cluster.local" disable_iss_validation=true
* vault write auth/kubernetes/role/vault-app bound_service_account_names=vault-app bound_service_account_namespaces=default policies=vault-app

### app-policy

```

path "secret*" {
    capabilities=["read"]
}

path "secret*" {
    capabilities=["read"] 
}

```

```
/ $ vault policy write vault-app - <<EOH
> path "dev/database/config" { capabilities = ["read"]}
> EOH
> ```

#### Harness
