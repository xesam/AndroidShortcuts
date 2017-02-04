## Android 快捷方式 Demo

1. launcher shortcut
2. App Shortcuts

## 问题

文档中说：

    Pinning Shortcuts
    Launcher apps allow users to pin shortcuts so they're easier to access.
    Both static and dynamic shortcuts can be pinned.
    Pinned shortcuts cannot be removed by publisher apps;
    they're removed only when the user removes them, when the publisher app is uninstalled,
    or when the user performs the clear data action on the publisher app from the device's Settings app.

也就是说 APP 不能主动删除 Pinned Shortcuts，但是有的 launcher 在清除数据之后也不会删除 Pinned Shortcuts，结果就是动态添加的 Pinned Shortcuts 无效，静态的依旧有效

