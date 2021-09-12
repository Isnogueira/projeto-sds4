import axios from "axios";
import Chart from "react-apexcharts";

import { useState } from "react";
import { useEffect } from "react";
import { BASE_URL } from "utils/requests";
import { round } from "utils/formats";
import { SaleSuccess } from "types/sale";



type SeriesData = {
    name: string,
    data:number[]

}

type ChatData = {
    labels: {
        categories: string[]
    },

    series: SeriesData[]

}

function BarChart() {

    const [chatData, setChartData] = useState<ChatData>(
            
            {labels: {
                categories: []
            },
            series: [
                {
                    name: "",
                    data: []                   
                }
            ]
        })

        useEffect(()=> {
            axios.get(`${BASE_URL}/sales/success-by-seller`)
                .then(response=> {
                    const data = response.data as SaleSuccess[];
                    const myLabels = data.map(x => x.sellerName);
                    const mySeries = data.map(x => round(100.0 * x.deals / x.visited , 1));
                    setChartData({ 
                            labels: {
                                categories: myLabels
                            },
                            series: [
                                {
                                    
                                    name: "%Success",
                                    data: mySeries
                                }
                            ]
                        });
                    })
                }  ,[])
                    
    
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        }
    }
    


    return (

        <Chart
            options={{...options, xaxis: chatData.labels}}
            series={chatData.series}
            type="bar"
            height="240"
        />

    )
              

}

    


export default BarChart;
