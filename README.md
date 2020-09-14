# work_1
对话框

遇到的问题
可以从登录框中获取到正确的用户名和密码，但是在判断是否在登录成功的语句中不能成功匹配。最后将判断语句改为
UserId.getText().toString().equals("abc") && Password.getText().toString().equals("123")
问题得以解决。
