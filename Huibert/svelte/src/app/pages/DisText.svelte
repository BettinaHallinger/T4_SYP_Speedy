<script>
    let name = '';
    let eingabeL;

    updateLength();
    function updateLength() {
        eingabeL = document.getElementById("eingabeL")?.innerHTML.length;
        console.log(eingabeL);

    }

    function setSessionStorage() {
        sessionStorage.setItem("displayText", name);
        console.log(window.sessionStorage.getItem("displayText"));
    }


</script>

<div class = "textField">
    <h1>Displaytext</h1>
    <p>Text darf nicht mehr als 160 Zeichen beinhalten.</p>
    <p>Text: <span id="demo">{name}</span></p>
    <input class = "eingabe" type="string" maxlength=160 on:input={setSessionStorage} id ="inputBtn" on:input={updateLength} bind:value={name}>
    <p>Zeichen: <span id ="demo2">{name.length}</span></p>


</div>

<style>
    /* h1{
        margin-bottom: 5%;
    }
 */	:global(body) {
        background-color: #2e2e2e;
        padding: 0;
        margin: 0;
        overflow-x: hidden;
        color: white;
        font-family: 'Courier New', Courier, monospace;
    }
    p{
        font-weight: bold;
        font-size: 15px;
        color: rgb(150, 150, 150);
    }
    .textField{
        width: 80%;
        padding-left: 10px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    .eingabe{
        background-color: #0E80C8;
        color: #fff;
        border-radius:15px;
        border: 2px solid #0E80C8;
        width: 50%;
        /* height: 100px; */

    }


</style>