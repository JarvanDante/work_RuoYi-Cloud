# Jenkins 接入说明

## Jenkins 节点要求

- JDK 17 或更高版本
- Maven 3.9+
- Git
- Docker
- Jenkins Docker Pipeline 插件

流水线会执行：

1. `mvn -B clean verify` 构建并验证全部后端模块。
2. 在 `node:18-bullseye` 容器中执行 `npm ci` 和 `npm run build:prod` 构建前端。
3. `main` 分支执行 `docker/copy.sh`，准备 Docker 构建上下文。
4. 归档各服务 JAR 和前端 `dist`。

前端生产构建结果是静态文件，不需要 Node 进程常驻运行。仓库现有
`docker/docker-compose.yml` 会通过 `ruoyi-nginx` 容器提供前端页面。

## 创建 Jenkins 任务

1. Jenkins 新建 `Pipeline` 或 `Multibranch Pipeline`。
2. 配置仓库地址和访问凭据。
3. Pipeline Definition 选择 `Pipeline script from SCM`。
4. Script Path 填写 `Jenkinsfile`。
5. 在 Git 服务中配置 Webhook，指向 Jenkins 的 Webhook 地址。

## 部署前检查

仓库当前的 `docker/docker-compose.yml` 包含默认 MySQL 密码和 Nacos 占位认证信息。
正式部署前，应将密码和 Token 改为环境变量或 Jenkins Credentials，并在目标服务器单独执行：

```bash
docker compose -f docker/docker-compose.yml build
docker compose -f docker/docker-compose.yml up -d
```

不要在未替换默认凭据前开放 MySQL、Redis、Nacos 等端口。
