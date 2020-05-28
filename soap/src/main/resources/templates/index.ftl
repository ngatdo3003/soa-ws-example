<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Caculator</title>
      <link rel="stylesheet"
           type="text/css" href="<@spring.url '/css/style.css'/>"/>
   </head>
   <body>

      <div>
         <fieldset>
            <legend>Caculator</legend>
            <form name="caculator" action="" method="POST">
               First number: <@spring.formInput "operator.number1" "" "text"/>    <br/> <br/>
               Second number: <@spring.formInput "operator.number2" "" "text"/>    <br/><br/>
               <input type="submit" value="Get sum" /> <br/><br/>
               <#if operator.result??>
                  Result: ${operator.result} <br/>
               </#if>

            </form>

         </fieldset>
      </div>


   </body>

</html>