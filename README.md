# Kubernetes Native Java with Spring Boot

Demonstration of:

- Cloud native development with Spring Boot and Reactive Spring
- Containerization with Cloud Native Buildpacks
- Kubernetes deployment manifests, graceful shutdown, and health probes
- Spring Boot configuration through ConfigMaps
- Native executables with Spring Boot 3 and GraalVM
- Serverless applications on Knative

## Prerequisites

To run all the examples, you need to install the following tools:

* [Java 17](https://adoptium.net)
* [Docker](https://www.docker.com)
* [Kubernetes CLI](https://kubernetes.io/docs/tasks/tools/)
* [kind](https://kind.sigs.k8s.io/docs/)

Recommended tools:

* [Octant](https://octant.dev)
* [Knative CLI](https://knative.dev/docs/client/)

## Usage

Both Spring Boot applications can be run locally with this command:

```shell
$ ./gradlew bootRun
```

You can containerize them via Buildpacks. Book Service will be containerized as a JVM image, whereas Book Native will be containerized as a native image.

```shell
$ ./gradlew bootBuildImage
```

## Deployment on a local Kubernetes cluster

You can spin up a Kubernetes cluster as follows:

```shell
$ ./kind/create-cluster.sh
```

Then, deploy Book Service with kubectl:

```shell
$ kubectl apply demo-service/config
```

When you're done, you can destroy the cluster as follows:

```shell
$ ./kind/destroy-cluster.sh
```

## Deployment on a local Kubernetes cluster with Knative

You can spin up a Kubernetes cluster with Knative as follows:

```shell
$ ./kind/install-knative.sh
```

Then, deploy Book Native with kubectl:

```shell
$ kubectl apply demo-service/knative
```
