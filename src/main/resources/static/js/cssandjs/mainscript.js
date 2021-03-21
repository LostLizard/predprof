var cityData;
var mediansData;
function getCityData(cityId){
    let url="/day?cityId="+cityId;
    let x=new XMLHttpRequest();
    x.open("GET",url,true);
    x.send(null);
    x.onload=function(){
        if(x.status==200){
            alert("пришло");
            cityData=prognozData(parser(x.responseText));
                 alert(cityData.length);
                 alert(cityData);
                 alert(cityData[364]);
        }
        else {
        }

    }
}
function parser(data){
    let help=data.split("#");
    let secondData;
    alert(help.length);
    for(let i=0;i<help.length;i++){
        secondData[i/20][i%20]=help[i];
    }
    alert("parsed");
}
function prognozData(data){
    let helpData;
    let nextData;
    for(let i=1;i<data.length;i++){
        for(let j=0;j<data[i].length;j++){
            helpData[j]=helpData[j]+(data[i][j]-data[i-1][j])
        }
    }
    for(let i=0;i<data[0].length;i++){
        helpData[i]=helpData[i]/(data.length-1);
        nextData[i]=data[data.length][i]+helpData[i];
    }
    return nextData;
}
function getMedians(cityId){
    let url="/med?cityId="+cityId;
    let x=new XMLHttpRequest();
    x.open("GET",url,true);
    x.send(null);
    x.onload=function(){
        if(x.status==200){
           mediansData=parser(x.responseText);
           alert(mediansData);
        }
    }
}