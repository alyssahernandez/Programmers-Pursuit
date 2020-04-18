/**
 * REPLACES DIE ROLL BUTTON WITH DIE IMG OF CURRENT ROLL AND UPDATES HUD MESSAGE
 */
function rollDie(button, img, message1, message2) {
    button.style.display = 'none';
    img.style.display = 'block';

    message1.style.display = 'none';
    message2.style.display = 'block';
}

/**
 * HIGHLIGHTS REACHABLE SPACES
 */
function highlightAvailableSpaces() {
    const reachableSpaces = document.querySelectorAll('.space__reachable');
    reachableSpaces.forEach((space) => {
        space.style.border = '3px solid #0fb9b1';
        space.style.boxShadow = '0 0 .5rem #0fb9b1';
    })
}

document.addEventListener("DOMContentLoaded", () => {

    // THIS SETS UP THE CLICK FUNCTIONALITY FOR ALL SPACES
    const spaces = document.querySelectorAll('.space');
    spaces.forEach( (space) => {
        space.addEventListener('click', (event) => {            
            console.log("clicked on a space");            
            const form = event.target.querySelector('form');            
            if (form) {                
                console.log("about to submit form");                
                form.submit();
            }            
        });
    });

    // THIS SETS UP THE DIE ROLL BUTTON
    const dieRollButton = document.getElementById('rollDie');
    const dieImg = document.getElementById('dieImg');
    const hudPrimary = document.querySelector('.hud-message--primary');
    const hudRoll = document.querySelector('.hud-message--rolled');
    dieRollButton.addEventListener('click', () => {
        rollDie(dieRollButton, dieImg, hudPrimary, hudRoll);
        highlightAvailableSpaces();
    })

});