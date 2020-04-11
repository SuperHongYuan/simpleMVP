# simpleMVP
一个简单基础的MVP框架，使用了 OKHttp，butterknife，eventbus，fastjson，retrofit2，glide，greendao，zxing，rxjava 等框架

# MVP模式简介
MVP（Model-View-Presenter）架构设计，是当下较为流行开发模式，目前主要以Google推出的TodoMVP为主

MVP模式解决了MVC中存在的分层问题,Presenter层被突出强调,实际上也就是真正意义上实现了的MVC

MVP不是一种框架,它实际上更类似一种分层思想,一种接口约定,具体体现在下面:
 + 定义IView接口,并且在接口中约定View层的各种操作,使用android.view.View的子类以xml构建文件构建起的布局和Activity/Fragment作为布局控制器,实现IView这个View层的接口,View层的实际实现类保留一个IPresenter接口的实例.
 + 定义IPresenter接口,并且在接口中约定Presenter层的各种操作.可以使用一个与View无关的类实现它,一般是XxxPresenterImpl.通常情况下Presenter层会包含Model层的引用和一个IView接口的引用,但不应该直接或者间接引用View层android.view.View的子类,甚至是操作的参数中也最好不要有android.view.View的子类传进来,因为它应该只负责业务逻辑和数据的处理并通过统一的接口IView传递到View层.
 + 不需要为Model层定义一个IModel的接口,这一层是改造最小的.以前该怎么来现在也差不多该怎么来.但是现在Presenter把它和View隔开了,
Presenter就可以作为一段独立的逻辑被复用.

# 本项目包结构

> + MVP
>   + controller 契约类，用于绑定 IView 和 IPresenter 
>   + model 数据获取类，用于获取网络或者本地的数据
>   + presenter 主导处理 model 的数据和运算将处理好的数据提交到 view中显示
>   + view  实际上展示的页面，包括 activity，fragment，dialog和自定义控件等
>   + api 网络接口信息
>   + bean  数据基类
>   + daoManager    数据库操作类
>   + utils 工具类

![](https://user-gold-cdn.xitu.io/2020/4/11/17168f2094a76f4a?w=344&h=563&f=png&s=12618)

