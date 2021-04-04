import {allocatePiece} from "./AllocatePiece.js";

export const serveInitialBoard = () => {
    const $startButton = document.getElementById("start-button");
    $startButton.addEventListener("click", function(e) {
        requestInitialBoard();
    })
}

const requestInitialBoard = () => {
    const pieces = document.getElementsByClassName("PackedPiece");
    
    Array.from(pieces).forEach(function(element) {
        element.remove();
    });

    axios.post("/initial")
    .then(response => allocatePiece(response))
    .catch(error => console.log(error)); 
}

