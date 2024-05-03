console.log("script loaded...");

let currentTheme = getTheme();
//console.log(currentTheme);

//initial -->
changeTheme();

//Todo
function changeTheme(){

    //set current theme to web page
    document.querySelector("html").classList.add(currentTheme);

    const changeThemeBtn = document.querySelector("#change_theme_btn");

    // Update the text of button initially
    changeThemeBtn.querySelector("span").textContent = currentTheme == "dark" ? "Light" : "Dark";

    //set the listner to change theme button
    changeThemeBtn.addEventListener("click",(event)=>{
        
        console.log("change theme btn clicked..");
        const oldTheme = currentTheme;

        if(currentTheme=="dark"){
            //theme to light
            currentTheme = "light";
        }else{
            //theme to dark
            currentTheme = "dark";
        }

        //localstorage me update karenge
        setTheme(currentTheme);

        //remove the current theme from html
        document.querySelector('html').classList.remove(oldTheme);

        //set the current theme to html
        document.querySelector('html').classList.add(currentTheme);

        // Update the text of button
        changeThemeBtn.querySelector("span").textContent = currentTheme == "dark" ? "Light" : "Dark";

    });
    

}

//set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

