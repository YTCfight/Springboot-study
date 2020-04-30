<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<p>文章的标题：${article.title} </p>
<p>文章的内容：${article.content} </p>
<p>文章创建时间：${article.createdAt?string('yyyy-MM-dd HH:mm:ss')} </p>
<p>用户名：${article.user.username} </p>
<p>用户昵称：${article.user.nickname} </p>

</body>
</html>