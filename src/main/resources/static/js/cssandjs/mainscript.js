import React from "";
import {CartesianGrid, Line, LineChart, XAxis, YAxis} from "recharts";

import MetaTags from 'react-meta-tags';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';
//import React, {useCallback} from 'react';

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
            Information();
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

const Information = () => {
   // const getting_data = async(url) => {
        //try {
          //  const response = await fetch(url, 'GET');
            const data = cityData;//await response.json();
          //  if (!response.ok) {throw new Error(data.message || 'SOMETHING WENT WRONG...')};
            return data;

        //} catch (e) {
        //    throw e
       // };
    const polyarniy = async(event) => {getting_data('/polyarniy')}
    const portoviy = async(event) => {getting_data('/portoviy')}
    const primorskiy = async(event) => {getting_data('/primorskiy')}


    const dates = JSON.parse(localStorage.getItem('days'));
    console.log(dates);

    var showValues = []
    for (let i = 1; i < dates; i++) {
        showValues.push({date: i, temp: i*3, pv: 2400, amt: 2400})
    }

    const Cnange_time = async(days) => {
        localStorage.setItem('days', JSON.stringify(365 - days));
    }


    const Change_on_day = async(event) => {Cnange_time(1)};
    const Change_on_week = async(event) => {Cnange_time(7)};
    const Change_on_month = async(event) => {Cnange_time(28)};


    return (
        <div>
            <MetaTags>
                <title>ГОРОДА</title>
                <meta name="viewport" content="width=device-width, initial-scale=0.1"/>
            </MetaTags>
            <div className="input-graph-form">
                <input type="submit" value="ПОЛЯРНЫЙ" onClick = {polyarniy}/>
                <input type="submit" value="ПОРТОВЫЙ" onClick = {portoviy}/>
                <input type="submit" value="ПРИМОРСКИЙ" onClick = {primorskiy}/>
            </div>
            <div className="graph">
                <LineChart width={window.document.body.clientWidth - 50} height={document.documentElement.scrollHeight*0.59} data={showValues}>
                    <Line type="monotone" dataKey="temp" stroke="#73f224" activeDot={{ r: 5 }}/>
                    <CartesianGrid stroke="#c227a8" strokeDasharray="5 1"/>
                    <XAxis dataKey="date"/>
                    <YAxis dataKey="temp"/>
                </LineChart>
            </div>
            <div className="input-time-form">
                <input type="submit" value="день" onClick = {Change_on_day}/>
                <input type="submit" value="неделя" onClick = {Change_on_week}/>
                <input type="submit" value="месяц" onClick = {Change_on_month}/>
            </div>
        </div>
    )
};