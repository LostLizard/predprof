import React, {useCallback} from 'react';
import MetaTags from 'react-meta-tags';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

export const Information = () => {
  const getting_data = async(url) => {
      try {
        const response = await fetch(url, 'GET');
        const data = await response.json();
        if (!response.ok) {throw new Error(data.message || 'SOMETHING WENT WRONG...')};
        return data;
        console.log(data);
      } catch (e) {
        throw e
      };
    }

  const polyarniy = async(event) => {getting_data('/polyarniy')}
  const portoviy = async(event) => {getting_data('/portoviy')}
  const primorskiy = async(event) => {getting_data('/primorskiy')}

  var showValues = [{date: 12, temp: 2, pv: 2400, amt: 2400},
                {date: 13, temp: 15, pv: 2400, amt: 2400},
                {date: 14, temp: 37, pv: 2400, amt: 2400},
                {date: 25, temp: 114, pv: 2400, amt: 2400}]
  console.log(showValues.date);
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
    </div>
  )
};
