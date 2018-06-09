// $(function() {
//   $.post("http://localhost:8080/topdecks/card/getRandomCard",
//     {
//       cardNum : 1
//     },
//         function(data,status){
//           $('#slideImg').attr("src",data[0].cardImgUrl);
//     });
// });
//const host = "http://localhost:8080/topdecks"; //测试环境
const host="/topdecks";// 生产环境
//检测登录状态
$(function() {
  username = localStorage.getItem("userName");
  $('#notLogin').hide();
  $('#logined').hide();
  if(username!=null){
    $('.username').text(" "+username);
    $('#logined').show();
  }
  else $('#notLogin').show();
});

//由卡牌名获取卡牌信息
function getCardByName(name) {
  url = host + "/card/getRandomCard?cardNum=1";
  $.get(url,function(data,status){
    cardId = data[0].cardId;
    imgUrl = ''+data[0].cardImgUrl+'';
    $('#card').attr("src",imgUrl);
  })
  
}



//登录
function login(){
  username = $('#username').val();
  password = $('#password').val();
  $(function() {
      $.post(host + "/user/login",
        {
          userName : username,
          password : password
        },
            function(data,status){
              if(data == 0){
                  localStorage.setItem("userName",username);
                  location.href = "home.html";
              }
              else if (data == -1) alert("用户不存在！");
              else if (data == -2) alert("用户与密码不对应！");
              else alert("登录错误！");
        });
    });
}


//注销
function logout(){
  localStorage.removeItem("userName");
  window.location.href = "login.html";
}