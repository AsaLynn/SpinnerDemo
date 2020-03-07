# hulu_android

#### 介绍
hulu_android


#### 日志调试
DashSpinner: --mnIndeterminateStartPosition: 285.0--mnArcLength:45.0
I/DashSpinner: --mnIndeterminateStartPosition: 0.0--mnArcLength:45.0
--mnIndeterminateStartPosition: 271.0--mnArcLength:45.0
271.99--mnArcLength:45.0
272.97--mnArcLength:45.0
273.94--mnArcLength:45.0
274.9--mnArcLength:45.0
275.85--mnArcLength:45.0
mnIndeterminateStartPosition
postInvalidate();
360.0--mnArcLength:45.0
app:arcStartPosition="270.0"

public void setProgress(float nProgress) {
    if (mCurrentDashMode.equals(DASH_MODE.NONE) || mCurrentDashMode.equals(DASH_MODE.DOWNLOAD)) {
        mCurrentDashMode = DASH_MODE.DOWNLOAD;
        mnProgress = (nProgress < 0.0f) ? 0.0f : ((nProgress > 1.0f) ? 1.0f : nProgress);
        postInvalidate();
    }
}

#### 安装教程


#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
