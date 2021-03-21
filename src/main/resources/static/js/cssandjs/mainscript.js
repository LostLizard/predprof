var cityData;
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
                 alert(cityData.length);
                 alert(cityData);
                 alert(cityData[364]);
        }
        else {
        }

    }
}
function prognozData(data){
    let helpData;
    let nextData;
    for(let i=0;i<365;i++){
        for(let j=1;j<20;j++){
            helpData[i]=helpData[i]+data[i+j*365]-data[i+(j-1)*365]
        }
    }
    for(let i=0;i<data[0].length;i++){
        helpData[i]=helpData[i]/(19);
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