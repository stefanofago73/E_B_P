## Exceptions Best Practices (collection) ##


### Description ###

This a simple (raw) project offer a complete framework<br/>
to manage Exceptions in a performant way<br/> 
<br/>
<br/>
We normally do not put a lot of care in the management of exceptions.<br/>
This tiny framework offer different approaches to manage exception<br/>
in a better way, looking at performance<br/>
<br/>
<br/>
So, we have:<br/>
<br/>
Stackless Exception an RuntimeStacklessException (Java 5,6,7,8)<br/>
<br/>
Swapping policy to exchange StackTraces<br/>
<br/>
<pre><code>

StackSwapper.swap([exc1],[exc2]);

StackSwapper.swap([exc1],[exc2], swapPolicy);

</code></pre>
<br/>
Throwing checked exception as runtime exception<br/>
<br/>
<pre><code>

ExceptionsThrower.throwAsUnchecked( new IOException(...));

</code></pre>
<br/>
Ability to build the caller sequence<br/>
<br/>
<pre><code>

Class<?>[] callers = Callers.obtain();

</code></pre>
<br/>
Ability to pile up errors descriptions in different part of a program<br/>
and then trasform them in an Exception<br/>
<br/>
<br/>
Ability to cache an expensive Exception<br/>
<br/>
<br/>
<br/>
So, now...Try to not only chain exceptions!<br/>
Take care of your exceptions and plkay safely ;-P<br/>
<br/>
<br/>