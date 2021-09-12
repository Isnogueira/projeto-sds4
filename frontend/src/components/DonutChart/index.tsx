import axios from "axios";
import Chart from "react-apexcharts";
import {BASE_URL} from "utils/requests";
import {SaleSum} from "types/sale";

type ChatData = {
    labels : string[]
    series : number[]
}

function DonutChart() {

    // FORMA ERRADA
    let chatData : ChatData = { labels: [], series: []};

    // FORMA ERRADA
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response=> {

            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            let chatData : ChatData = { labels: myLabels, series: mySeries};

            console.log(chatData);
        })

  /*  const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }*/
    
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
