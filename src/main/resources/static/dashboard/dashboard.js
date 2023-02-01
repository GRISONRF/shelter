console.log("inside dashboard")
/////////////////////////// DOG VS CAT /////////////////////////////
const animalDivs = document.querySelectorAll('div[data-animal]');
let animals = [];
animalDivs.forEach(div => {
  const animalName = div.querySelector('p[data-name]').getAttribute('data-name');
  const animalSpecies = div.querySelector('p[data-species]').getAttribute('data-species');
  animals.push({ name: animalName, species: animalSpecies });
});
console.log(animals)

// Step 1: Create the chart canvas
var canvas = document.getElementById("myChart");
var ctx = canvas.getContext("2d");

// Step 2: Set chart data
var chartData = {
    labels: [],
    datasets: [{
        label: '# of each species',
        data: [],
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


// Step 3: Count the number of each species in the animals array
const speciesCounts = animals.reduce((counts, animal) => {
  if (!counts[animal.species]) {
    counts[animal.species] = 0;
  }
  counts[animal.species]++;
  return counts;
  }, {});

// Step 4: Populate chart labels and data based on species count
for (const species in speciesCounts) {
  chartData.labels.push(species);
  chartData.datasets[0].data.push(speciesCounts[species]);
  }

// Step 5: Initialize chart
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: chartData,
    options: {
        responsive: false,
        maintainAspectRatio: false,
        title: {
            display: true,
            text: "Dogs vs Cats"
        }
    }
});



//////////////////////////////////////// MALE VS FEMALE /////////////////////////////////////
const animalDivs2 = document.querySelectorAll('div[data-animal]');
let animals2 = [];
animalDivs2.forEach(div => {
  const animalGender = div.querySelector('p[data-gender]').getAttribute('data-gender');
  animals2.push(animalGender);
});
console.log(animals2);

// Step 1: Create the chart canvas
var canvas2 = document.getElementById("myChart2");
var ctx2 = canvas2.getContext("2d");

// Step 2: Set chart data
var chartData2 = {
    labels: [],
    datasets: [{
        label: '# of each gender',
        data: [],
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

// Step 3: Count the number of each gender in the animals array
const genderCounts = animals2.reduce((counts, animal) => {
  if (!counts[animal]) {
    counts[animal] = 0;
  }
  counts[animal]++;
  return counts;
  }, {});

// Step 4: Populate chart labels and data based on gender count
for (const gender in genderCounts) {
  chartData2.labels.push(gender);
  chartData2.datasets[0].data.push(genderCounts[gender]);
}

var myPieChart2 = new Chart(ctx2, {
    type: 'pie',
    data: chartData2,
    options: {
        responsive: false,
        title: {
            display: true,
            text: "Male vs Female"
        }
    }
});




//////////////////////////////////////// AVAILABILITY /////////////////////////////////////


