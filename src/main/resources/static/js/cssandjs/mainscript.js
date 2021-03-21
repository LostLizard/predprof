var cityData=new Array(365).fill(0);
var mediansData;
function getCityData(cityId){
    let url="/day?cityId="+cityId;
    let x=new XMLHttpRequest();
    x.open("GET",url,true);
    x.send(null);
    x.onload=function(){
        if(x.status==200){
            let dayData=x.responseText.split("#");
            cityData=prognozData(dayData);
         //   mediansData=getMedians(dayData);
        }
        else {
        }

    }
}
function prognozData(data){
    let helpData=new Array(365).fill(0.0);
    for(let i=0;i<365;i++){
        helpData[i]=(data[365*19+i]-data[i])/19;//helpData[i]+
    }
    return helpData;
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