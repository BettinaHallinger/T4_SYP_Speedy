<script  context="module">

    import Home from '../pages/Home.svelte';
    import MotorG from '../pages/MotorG.svelte';
    import LED from '../pages/LED.svelte';
    import DisText from '../pages/DisText.svelte';
    import UmschG from '../pages/UmschG.svelte';
    import WlanM from '../pages/WlanM.svelte';
    import Login from '../pages/Login.svelte';


    export let value = Home;
    //Nach dem klicken auf den Button Motorgeschwindigkeit, öffnet sich die Seite der Motorgeschwindigkeit
    //TODO: Take the 'routeChange' variable from +page.svelte and use it in a switch-case (in 'Router.svelte') to not use a function for every single button
    export function onclickMG(){
        value = MotorG;
        console.log(value.name);
    }

    export function onclickHome(){
        value = Home;
        console.log(value.name);
    }

    export function onclickLED(){
        value = LED;
        console.log(value.name);
    }

    export function onclickDisText(){
        value = DisText;
        console.log(value.name);
    }

    export function onclickUmschG(){
        value = UmschG;
        console.log(value.name);
    }

    export function onclickWlanM(){
        value = WlanM;
        console.log(value.name);
    }

    export function showRoute(){
        console.log(value.name);
    }

    export function onclickLOG() {
        value = Login;
        console.log(value.name);
    }
</script>

<svelte:component this={value}/>