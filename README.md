# DrawableView
可以在布局中直接设置shape背景属性，快速编写带样式的组件.  
目前内置TextView，LinearLayout和View，其他请自行扩展.

## Features

* 支持所有shape标签的属性
* TextView 设置drawable可以设置图片大小
* TextView 的drawable支持添加点击事件
* Animator动态改变背景

## How To Use  

Step 1. Add the JitPack repository to your build file

```
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency
```
dependencies {
	implementation 'com.github.biby0915:DrawableView:1.0.0'
}
```

在布局文件中使用

![xml](https://github.com/biby0915/DrawableView/blob/master/preview/20190611113318.jpg)

预览

<img src ="https://github.com/biby0915/DrawableView/blob/master/preview/ftvya-pct04.gif" width="300">

背景效果可以在代码中设置，再也不用写一堆drawable文件了

```Java
//实现1
TextDrawableBackgroundImpl background = tv.getDrawableBackground();
        background.solidColor = Color.WHITE;
        background.bottomLeftRadius = 100;
        background.invalidate();
	
//实现2	
tv.getDrawableBackground().setBackgroundParams(new String[]{"solidColor", "cornerRadius"}, new Object[]{Color.BLACK, 10});
```

## Notes

* 按下背景和字体颜色改变需要设置 setOnClickListener.
* 除了DrawableTextView，其他控件由于共用一套attr，在xml不会自动提示自定义属性.
* animator属性暂时只支持 solidColor(填充色) 以及 cornerRadius(圆角).
