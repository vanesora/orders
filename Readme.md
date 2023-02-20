# Orders Spring Boot

## Crear JAR del pryecto

Cada vez que exista un cambio en el proyecto hay que crear un nuevo jar del proyecto:

```bash
./mvnw install
```

## Crear imagen

Cada vez que exista un cambio en el proyecto hay que crear un nueva imagen con:

```bash
sudo docker build -t unir/orders-back .
```

## Crear contenedor

```bash
sudo docker run -d --name orders-back__container_1 -p 8181:8181 unir/orders-back 
```