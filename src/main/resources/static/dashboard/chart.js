// Step 1: Create the chart canvas
var canvas = document.getElementById("myChart");
var ctx = canvas.getContext("2d");

// Step 2: Set chart data
var chartData = {
    labels: ["Dogs", "Cats"],
    datasets: [{
        label: '# of each specie',
        data: [12, 20],
        backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)'

        ],
        borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)'
        ],
        borderWidth: 1
    }]
};

// Step 3: Initialize chart
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: chartData,
    options: {
        responsive: true,
        maintainAspectRatio: false,
        title: {
            display: true,
            text: "Dogs vc Cats"
        }
    }
});
//
//var ctx = document.getElementById('myChart').getContext('2d');
//var chartData = [];
//
//// Get the data from the model
//var animals = document.getElementById(${animals});
//console.log(animals)
//console.log("inside of js")
//
//// Prepare the chart data
//animals.forEach(function(animal) {
//chartData.push({
//  x: animal.name,
//  y: animal.age
//});
//});
//
//var myChart = new Chart(ctx, {
//type: 'pie',
//data: {
//  labels: chartData.map(function(data) { return data.x; }),
//  datasets: [{
//    label: 'Animal Ages',
//    data: chartData.map(function(data) { return data.y; }),
//    backgroundColor: [
//      'rgba(255, 99, 132, 0.2)',
//      'rgba(54, 162, 235, 0.2)',
//      'rgba(255, 206, 86, 0.2)',
//      'rgba(75, 192, 192, 0.2)',
//      'rgba(153, 102, 255, 0.2)',
//      'rgba(255, 159, 64, 0.2)'
//    ],
//    borderColor: [
//      'rgba(255, 99, 132, 1)',
//      'rgba(54, 162, 235, 1)',
//      'rgba(255, 206, 86, 1)',
//      'rgba(75, 192, 192, 1)',
//      'rgba(153, 102, 255, 1)',
//      'rgba(255, 159, 64, 1)'
//    ],
//    borderWidth: 1
//  }]
//},
//options: {}
//});

myChart.update();
//myChart.render();