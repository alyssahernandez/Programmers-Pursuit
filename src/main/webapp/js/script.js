/**
 * REPLACES DIE ROLL BUTTON WITH DIE IMG OF CURRENT ROLL
 */
function rollDie(button, img) {
    button.style.display = 'none';
    img.style.display = 'block';
}

/**
 * HIGHLIGHTS REACHABLE SPACES
 */
function highlightAvailableSpaces() {
    const reachableSpaces = document.querySelectorAll('.space__reachable');
    reachableSpaces.forEach((space) => {
        space.style.border = '1px solid #0fb9b1';
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
    dieRollButton.addEventListener('click', () => {
        rollDie(dieRollButton, dieImg);
        highlightAvailableSpaces();
    })

});