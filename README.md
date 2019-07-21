

### 前言
- 旨在使用定制化Json内容，快速生成客户端界面，并带一定的业务逻辑，
- 第一个迭代选取最常用的基础组件，及容器类组件，以求能达到快速生成展示类页面；
并在后面迭代快速增加类如input，checkbox ，radio，等输入控件，实现交互类页面
- 部分客户端固定页面可在apk内打包json文本文件，后期通过服务端下发实现应用内热更新
- 最终目标以扩展控件形式增加魔法页面功能，比如支付控件，音频控件，列表的刷新动效，及更灵活的界面方式，后台的可视化控件布局

## 魔法页面
``` 
class MagicPagerModel {
    //页面背景颜色
    var bgColor: String = "#ffffff" 
    //页面背景图片
    var bgImage: String? = null 
    //页面描述 （仅用于json查看）
    var desc: String? = null
    //页面控件列表
    var widgets: ArrayList<BaseWidgetModel> = ArrayList()
    //页面是否支持下拉刷新 默认false
    var refreshable: Boolean = false 
    //页面导航栏
    var navigationBar: NavigationBarModel? = null
}

```

# 基础控件篇

## 公共属性
控件基础属性
```
open class BaseWidgetModel {
    //控件类型
    var type: WidgetModelType = WidgetModelType.BLANK_TYPE
    //控件背景颜色 默认透明
    var bgColor: String = "#00000000"
    //控件宽度/高度 -2:自适应宽度，-1:充满父控件 其他:单位长度
    var width: Double = -2.0
    var height: Double = -2.0
    //边框 单位长度边宽
    var border: Int = 0
    //边框颜色
    var borderColor: String = "#00000000"
    //控件圆角角度
    var corner: Int = 0
    //内边距
    var padding: String = "0,0,0,0"
    //外边距
    var margin: String = "0,0,0,0"
    //控件xy坐标
    var x: Int = 0 //根据某些父容器适用
    var y: Int = 0 //根据某些父容器适用
    //控件位置 NONE:默认线性排布 FIX:固定于上下左右 FLOAT:上下左右浮动
    var position: WidgetModelPosition = WidgetModelPosition.NONE

    //action 控件点击事件，可解析js方法
    var action: String? = null
    //本地构建model使用 传入
    var actionBlock: MagicAction? = null
    //不可点击，不拦截点击事件
    val disable = false
    //view 重用id 0表示不重用 至少同个type下唯一
    var reuseId: Int = 0
}
```

## 基础控件
### TextWidget 文本控件
```
class TextWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.TEXT_TYPE
    }
    //文本内容
    var text: String? = null
    //字体大小（单位大小）
    var textSize: Int = 15
    //字体颜色
    var textColor: String = "#000000"
    //行距（单位大小）
    var lineSpacing: Int = 1
    //最大行数
    var maxLines: Int = 1
    //字体水平对其方向
    var textHorizontalAligment: HorizontalAligment = HorizontalAligment.LEFT
    //字体垂直对其方向
    var textVerticalAligment: VerticalAligment = VerticalAligment.TOP
    //是否粗体
    var bold: Boolean = false
    //是否斜体
    var italic: Boolean = false
}
```
### ImageWidget 图片控件
```
class ImageWidgetModel : BaseWidgetModel() {

    init {
        type = WidgetModelType.IMAGE_TYPE
    }
    
    //图片在线url
    var imgSrc: String? = null
    //本地图片资源Res
    var imgRes: Int? = null
    //图片填充方式
    var scaleType: ScaleType = ScaleType.INSIDE
    
    override fun toString(): String {
        return "ImageWidgetModel(imgSrc=$imgSrc, scaleType=$scaleType)"
    }
}
```

### ButtonWidget 按钮控件
```
{
    "widgets":[
        {
            "type":"button",
            "data":{
                "id":1,
                "text":"按钮文本", //按钮文本
                "textSize":15, //字体大小
                "textColor":"#333333", //字体颜色
                "bgImage":"http://....png", //按钮背景图片
                "icon":"http://....png" //按钮icon
            }
        }
    ]
}
```

### BlankWidget 空白控件 
用于占位或分割线，只含公共属性
```
class BlankWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.BLANK_TYPE
    }
}
```

### 4种基础控件示意图 （属性已上方代码为准）
![屏幕快照 2019-05-08 18.04.30.png](https://upload-images.jianshu.io/upload_images/17775851-9c709cefbde61fe8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



## 容器类控件
### CarouselWidget 走马灯
走马灯轮播控件
```
class CarouselWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.CAROUSEL_TYPE
    }
    
    //轮播间隔
    var duration: Long = 5000
    //是否自动轮播
    var autoPlay: Boolean = true
}
```

### GridWidget 网格控件
```
class GridWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.GRID_TYPE
    }

    //内容所分成行数
    var row: Int = 1
    //内容所分成列数
    var column: Int = 1
}
```

### 走马灯及网格控件展示效果图（属性以上方代码为准）：

![屏幕快照 2019-05-08 18.09.57.png](https://upload-images.jianshu.io/upload_images/17775851-5e3a275c4b8760c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### List 列表控件 
列表控件，单列模式，双列模式（瀑布流）
```
class ListWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.LIST_TYPE
    }

    //SINGLE：单列 DOUBLE：双列瀑布流
    var listType: ListWidgetType = ListWidgetType.SINGLE

}
```
### 列表控件 单列双列效果图

![屏幕快照 2019-05-08 18.12.19.png](https://upload-images.jianshu.io/upload_images/17775851-11c9395bc37adead.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



## 执行JS代码
action字段内使用js代码
格式：
```
"native.call('magic','show','{\"key\":\"test_ad\",\"type\":\"test\", \"params\":{\"params1\":\"1\",\"params2\":\"1\"}}',null)"
params 及callback可传null

/**
     * 响应js调用方法
     */
    fun call(type: String, key: String) {
        call(type, key, null, null)
    }

    fun call(type: String, key: String, params: String?) {
        call(type, key, params, null)
    }

    fun call(type: String, key: String, params: String?, callBack: Any?) {
        MLog.i("Sven", "call native type=$type, key=$key, params=$params")
        val jsonClass = object : TypeToken<HashMap<String, Any>>() {
        }.type

        val paramMap: HashMap<String, Any>? = MagicGson.gson.fromJson(params, jsonClass)

        val result = MagicPagerManager.get().getScriptBridge().invoke(
            context,
            type,
            key,
            paramMap
        )
        if (callBack is Function) {
            callBack.call(jsContext, scope, scope, arrayOf(result))
        }
    }
```
## sdk内实现
```
//finish当前魔法页面 
"native.call('magic','dismiss')" 

//showPager startActivity 传入key type params 跳转到一个新的魔法特面
"native.call('magic','show','{\"key\":\"test_ad\",\"type\":\"test\", \"params\":{\"params1\":\"1\",\"params2\":\"1\"}}',null)"
```


### 最后！！项目开源地址： https://github.com/SvenFang/MagicPager
后续将新增ios版本
