# cloud
* 目前的项目想 clone 到本地运行需要进行如下的操作：

  * 首先在自己电脑上创建一个MySQL数据库，并运行我提供的脚本文件。

  * 目前引入了consul注册中心，所以首先得安装好consul，并且使用**服务模式启动consul**，并且我在consul中做了全局配置（微服务连接数据的信息），数据是dev目录下的data文件夹，运行如下命令即可。

    * ```bash
      consul agent -server -ui -bootstrap-expect 1 -data-dir data文件夹所在的路径 -node=n1 -bind=127.0.0.1
      ```


  * 进入到consul首页修改key/value中的数据库信息即可运行。

