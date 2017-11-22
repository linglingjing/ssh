	$.validator.setDefaults({
		    submitHandler: function() {
		    	if (form.submit()) {
		    		$('#success').css("display","block");
		    	}else{
		    		$('#error').css("display","block");
			    };
		    }
		});
		$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#wizForm").validate({
			    rules: {
			      adminName: {
			        required: true,
			        minlength: 2
			      },
			      password: {
			        required: true,
			        minlength: 6,
			        maxlength:16
			      },
			      confirm_password: {
			        required: true,
			        minlength: 6,
			        maxlength:16,
			        equalTo: "#password"
			      },
			      adminType: "required"
			    },
			    messages: {
			      username: {
			        required: "请输入用户名",
			        minlength: "用户名必需由两个字母组成"
			      },
			      password: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 6 个字母",
			        maxlength: "密码长度不能大于 16 个字母"
			      },
			      confirm_password: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 6 个字母",
			        maxlength: "密码长度不能大于 16 个字母",
			        equalTo: "两次密码输入不一致"
			      },
			      adminType: "管理员类型必选"
			    }
			});
		});