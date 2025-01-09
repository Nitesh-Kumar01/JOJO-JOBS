const jobs = [
    {
        title: "Frontend Developer - Amazon",
        type: "Full Time",
        experience: "Fresher",
        location: "In-Office",
        posted: "1 day ago",
        skills: ["JavaScript", "Next.js", "Tailwind CSS"]
    },
    {
        title: "Backend Developer - Google",
        type: "Part Time",
        experience: "2+ Years",
        location: "Remote",
        posted: "2 days ago",
        skills: ["Node.js", "Express.js", "MongoDB"]
    },
    {
        title: "Data Scientist - Facebook",
        type: "Full Time",
        experience: "2+ Years",
        location: "Remote",
        posted: "3 days ago",
        skills: ["Python", "TensorFlow", "Data Analysis"]
    },
    {
        title: "UI/UX Designer - Adobe",
        type: "Full Time",
        experience: "Fresher",
        location: "In-Office",
        posted: "4 days ago",
        skills: ["Figma", "Sketch", "Prototyping"]
    }
];

const jobContainer = document.getElementById("job-list");
const popup = document.getElementById("popup");
const popupContent = document.getElementById("popup-content");

function renderJobs() {
    jobContainer.innerHTML = "";
    jobs.forEach(job => {
        const jobCard = document.createElement("div");
        jobCard.classList.add("job-card");
        jobCard.innerHTML = `
            <h2>${job.title}</h2>
            <p><strong>${job.type}</strong> - ${job.experience} - ${job.location}</p>
            <p>Posted: ${job.posted}</p>
            <button onclick="viewDetails('${job.title}')">Check</button>
        `;
        jobContainer.appendChild(jobCard);
    });
}

function viewDetails(jobTitle) {
    const job = jobs.find(j => j.title === jobTitle);
    popup.style.display = "flex";
    popupContent.innerHTML = `
        <h3>${job.title}</h3>
        <p><strong>Type:</strong> ${job.type}</p>
        <p><strong>Experience:</strong> ${job.experience}</p>
        <p><strong>Location:</strong> ${job.location}</p>
        <p><strong>Skills:</strong> ${job.skills.join(", ")}</p>
        <button id="apply-btn">Apply</button>
        <button id="close-popup-btn">Close</button>
    `;
    document.getElementById("apply-btn").onclick = () => {
        alert("Application Submitted!");
        popup.style.display = "none";
    };
    document.getElementById("close-popup-btn").onclick = () => {
        popup.style.display = "none";
    };
}

renderJobs();
