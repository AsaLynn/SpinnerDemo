# hulu_android

#### 介绍
弹出进度框.


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


#### 使用说明

历史版本:
```
implementation 'com.zxn.spinner:dash-spinner:1.0.3'
implementation 'com.zxn.spinner:dash-spinner:1.0.2'
```





