import axios from "axios";
import Chart from "react-apexcharts";
import { useState } from "react";
import { useEffect } from "react";
import { BASE_URL } from "utils/requests";
import { SaleSum } from "types/sale";

type ChatData = {
    labels : string[]
    series : number[]
}

function DonutChart() {

    const [chatData, setChartData] = useState<ChatData>({ labels: [], series: []}); 

    useEffect(()=> {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response=> {

            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            setChartData({ labels: myLabels, series: mySeries});
        })
    } , []);
    
    const options = {
        legend: {
            show: true
        }
    }
    

    return (

        <Chart
            options={{...options, labels: chatData.labels}}
            series={chatData.series}
            type="donut"
            height="240"
        />

    );
}

export default DonutChart;
