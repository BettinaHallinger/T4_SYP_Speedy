<script>

    let email = "";
    let password = "";
    let hasBeenClicked = false;

    /**
    * @param {string} email
    */
    
    function validateEmail(email) {
        var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;  
        return emailRegEx.test(String(email).toLowerCase());
    }
    
    
    function handleSubmission() {
        hasBeenClicked = true;
        if (isValidEmail && isValidPassword) {
            // Send data somewhere
            alert("submitted");
        }
    }

    $: isValidEmail = validateEmail(email);   
    $: isValidPassword = password.length >= 4;
    
</script>
    
    
    
    
    <div class = "textField">
        <h1>Login</h1>
        <div class="input-wrapper">
            <input class="eingabe" type="email" bind:value={email} placeholder="Email"/>
            {#if hasBeenClicked && !isValidEmail}
                <p class="validation-error">Invalid email</p>
            {/if}
                {#if isValidEmail}
            <p class="validation">Valid email</p>
            {/if}
        </div>
        
        <div class="input-wrapper">
            <input class="eingabe" type="password" bind:value={password} placeholder="Password"/>
                
            {#if hasBeenClicked && !isValidPassword}
            <p class="validation-error">Please enter a longer password</p>
                {/if}
            {#if isValidPassword}
            <p class="validation">Password is save.</p>
            {/if}
        </div>

        <button class="btnSubmit" on:click={handleSubmission} >Login</button>
    </div>

    <style>


    
.input-wrapper {
    flex: 1;
    text-align: left;
    padding-bottom: 20px;
}
  
.validation-error {
    color: rgb(176, 30, 30);
    margin-top: 5px;
}
    
.validation{
    color: green;
    margin-top: 5px;
}
    
h1 {
    text-align: center;
}
    
</style>