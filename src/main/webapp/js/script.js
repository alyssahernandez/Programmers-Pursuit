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
        space.style.border = '3px solid #4b7bec';
    })
}

document.addEventListener("DOMContentLoaded", () => {

    const dieRollButton = document.getElementById('rollDie');
    const dieImg = document.getElementById('dieImg');
    dieRollButton.addEventListener('click', () => {
        rollDie(dieRollButton, dieImg);
        highlightAvailableSpaces();
    })

});