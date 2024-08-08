import os


def generate_module_root(artifact_id, description=""):
    pom_template = '''<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.iocoder.boot</groupId>
        <artifactId>yudao</artifactId>
        <version>${{revision}}</version>
    </parent>

    <artifactId>{artifactId}</artifactId>
    <packaging>pom</packaging>

    <name>${{project.artifactId}}</name>
    <description>
        {description}
    </description>
    <modules>
        <module>{artifactId}-api</module>
        <module>{artifactId}-biz</module>
    </modules>
</project>'''

    return pom_template.format(artifactId=artifact_id, description=description)


def generate_module_api(parent_artifact_id, description=""):
    pom_template = '''<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.iocoder.boot</groupId>
        <artifactId>{parent_artifact_id}</artifactId>
        <version>${{revision}}</version>
    </parent>

    <artifactId>{parent_artifact_id}-api</artifactId>
    <packaging>jar</packaging>

    <name>${{project.artifactId}}</name>
    <description>
        {description}
    </description>
    
    <dependencies>
        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>yudao-common</artifactId>
        </dependency>
    </dependencies>
</project>'''

    return pom_template.format(parent_artifact_id=parent_artifact_id, description=description)


def generate_module_biz(parent_artifact_id, description=""):
    pom_template = '''<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.iocoder.boot</groupId>
        <artifactId>{parent_artifact_id}</artifactId>
        <version>${{revision}}</version>
    </parent>

    <artifactId>{parent_artifact_id}-biz</artifactId>
    <packaging>jar</packaging>

    <name>${{project.artifactId}}</name>
    <description>
        {description}
    </description>

    <dependencies>  <!-- 5. 新增依赖，这里引入的都是比较常用的业务组件、技术组件 -->
        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>{parent_artifact_id}-api</artifactId>
            <version>${{revision}}</version>
        </dependency>

        <!-- Web 相关 -->
        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>yudao-spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>yudao-spring-boot-starter-security</artifactId>
        </dependency>

        <!-- DB 相关 -->
        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>yudao-spring-boot-starter-mybatis</artifactId>
        </dependency>

        <!-- Test 测试相关 -->
        <dependency>
            <groupId>cn.iocoder.boot</groupId>
            <artifactId>yudao-spring-boot-starter-test</artifactId>
        </dependency>
    </dependencies>
</project>'''

    return pom_template.format(parent_artifact_id=parent_artifact_id, description=description)


def write_to_file(file_path, content):
    with open(file_path, "w", encoding="utf-8") as file:
        file.write(content)


if len(os.sys.argv) < 2:
    print("Please input artifactId and description")
    exit(1)

artifactId = os.sys.argv[1]

if len(artifactId) < 1:
    print("artifactId is empty")
    exit(1)

description = os.sys.argv[2] if len(os.sys.argv) > 2 else ""

# root
pom_content = generate_module_root(artifactId)
os.makedirs(artifactId, exist_ok=True)
write_to_file(f"{artifactId}/pom.xml", pom_content)

# api
api_dir = f"{artifactId}/{artifactId}-api"
os.makedirs(api_dir, exist_ok=True)
os.makedirs(f"{api_dir}/src/main/java", exist_ok=True)
os.makedirs(f"{api_dir}/src/main/resources", exist_ok=True)
os.makedirs(f"{api_dir}/src/test/java", exist_ok=True)
pom_content = generate_module_api(artifactId)
write_to_file(f"{api_dir}/pom.xml", pom_content)

# biz
biz_dir = f"{artifactId}/{artifactId}-biz"
os.makedirs(biz_dir, exist_ok=True)
os.makedirs(f"{biz_dir}/src/main/java", exist_ok=True)
os.makedirs(f"{biz_dir}/src/main/resources", exist_ok=True)
os.makedirs(f"{biz_dir}/src/test/java", exist_ok=True)
pom_content = generate_module_biz(artifactId)
write_to_file(f"{biz_dir}/pom.xml", pom_content)
