## Exceptions Best Practices (collection) ##


### Description ###

This is a simple (raw) project that offer a complete framework<br/>
to manage Exceptions looking at performance<br/> 
<br/>
<br/>
We normally do not put a lot of care in the management of exceptions.<br/>
This tiny framework offer different approaches to manage exceptions<br/>
in a better way<br/>
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
Take care of your exceptions and play safely ;-P<br/>
<br/>
<br/>