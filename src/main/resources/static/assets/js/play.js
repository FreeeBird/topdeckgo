var pack = new Array();
pack[0] = {
    free: 0,
    common : 0,
    rare: 0,
    epic:0,
    legend:0,
    num:0,
}
$.ajaxSetup (
    {
       async: false
    });
var opened = new Array();
for(var i = 1;i<=5; i++){
     opened[i]=0;
     pack[i]=[];
}

function openPack(packClass){
    var packId = packClass.substr(this.length-1,1);
    var pc = "PACK " + packClass;
    if(opened[packId]===1){
        alert("这个卡包已经打开了！");
        return;
    }
    opened[packId]=1;
    url = host + "/card/getRandomCard";
    $.post(url,{cardNum:5},
      function(data,status){
        console.log(data.toString());
        if(status !== "success") alert("error");
        pack[packId]=data[data];
      }
    );
    $(pc).children("img").attr("src","assets/img/pack-jd-opened.png");

    setTimeout(function(){
        for(var j=0;j<pack[packId].length;j++){
            pack[packId][j].opened = false;
        }
        var html = '<section class="am-panel am-panel-default am-panel-secondary cards">';
    html +='<div class="am-panel-hd"># '+ packId +'</div>';
    html +='<div class="am-panel-bd" style="text-align: center">';
    for(var i=0;i<pack[packId].length;i++){
        html +='<a onclick="openCard(this.id)" id='+packId +''+i +'><img class="pack-jd" style="margin:0 5px" src="assets/img/jd-back.png"></a>';
    }
    html +='</div></section>';
        $(".packs").after(html);
    },500);
    
}

function openCard(cardid){
    var num = parseInt(cardid);
    var i1 = parseInt(num / 10);
    var i2 = num % 10;
    $('#'+cardid).children("img").attr("src",pack[i1][i2].cardImgUrl);
    if(pack[i1][i2].opened) return;
    pack[i1][i2].opened = true;
    switch (pack[i1][i2].cardRarityNum) {
        case 0:
            pack[0].free++;
            $("#freeNum").text(pack[0].free);
            $("#freeAll").text(0);
            break;
        case 1:
            pack[0].common++;
            $("#commonNum").text(pack[0].common);
            $("#commonAll").text(1*pack[0].common);
            break;
        case 2:
            pack[0].rare++;
            $("#rareNum").text(pack[0].rare);
            $("#rareAll").text(2*pack[0].rare);
            break;
        case 3:
            pack[0].epic++;
            $("#epicNum").text(pack[0].epic);
            $("#epicAll").text(3*pack[0].epic);
            break;
        case 4:
            pack[0].legend++;
            $("#legendNum").text(pack[0].legend);
            $("#legendAll").text(4*pack[0].legend);
            break;
        default:
            break;
    }
    var num = pack[0].free+pack[0].common+pack[0].rare+pack[0].epic+pack[0].legend;
    var all = 0*pack[0].free+1*pack[0].common+2*pack[0].rare+3*pack[0].epic+4*pack[0].legend;
    $('#Num').text(num);
    $('#All').text(all);

}

