<!-- Design for the Motorgeschwindigkeit -->

<style>
    .slidecontainer{
        width: 80%;
        padding-left: 10px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 4em 0 4em 0;
    }

    .slider {
        -webkit-appearance: none;
        width: 80%;
        height: 5px;
        border-radius: 5px;
        background: #fff;
        outline: none;
        opacity: 0.7;
        -webkit-transition: .2s;
        transition: opacity .2s;
    }

    .slider:hover {
        opacity: 1;
    }

    .slider::-webkit-slider-thumb {
        -webkit-appearance: none;
        appearance: none;
        width: 20px;
        height: 20px;
        border: 2px solid #0E90C8;
        border-radius: 50%;
        background: #0E80C8;
        cursor: pointer;
    }

    .slider::-moz-range-thumb {
        width: 20px;
        height: 20px;
        border-radius: 50%;
        background: #0E80C8;
        cursor: pointer;
    }

    p{
        color: #fff;
        font-size: 18px;
        text-align: center;
    }

    #numField{
        margin-top: 3em;
        width: 100px;
    }

    /* Chrome, Safari, Edge, Opera */
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    /* Firefox */
    input[type=number] {
        -moz-appearance: textfield;
    }

</style>

<div class = "slidecontainer">
    <h1>Motorgeschwindigkeit</h1>
    <input bind:value={value} step="5" on:change={setSessionStorage}  type = "range" min = 0 max = 100 class ="slider" id="myRange">
<!--    <p>Value: <spafn id ="demo">{value}</span></p>-->
    <input class = "eingabe" type="number" id ="numField" bind:value={value} on:input={scream} min = 0 max = 100 >
</div>

<script>
    import { validate_void_dynamic_element } from "svelte/internal";
    import { browser } from "$app/env";

    let value = 0;

    if(sessionStorage.getItem("motor") != null) {
        value = sessionStorage.getItem("motor");
    }

    /**
     * @param event{any}
     */

    function setSessionStorage() {
        sessionStorage.setItem("motor", value);
        console.log(window.sessionStorage.getItem("motor"));
    }

    function scream(event) {

        const v = event.target.value;

        if ( v < 0 ) {
            value = 0
        } else if ( v > 100 ) {
            value = 100
        } else if (v === "") {
            value = 0;
        } else {
            value = v;
        }

        setSessionStorage();
    }


</script>