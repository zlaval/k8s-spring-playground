FOR /F %%A IN ('docker images demo-image -a -q --format {{.Repository}}:{{.Tag}}') DO (docker rmi --force %%A)
exit 0