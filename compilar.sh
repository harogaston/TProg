ant -lib ~/apache-ant-1.9.6/lib/ -f /~/git/TProg/ServidorCentral -Dnb.internal.action.name=rebuild clean jar
ant -lib ~/apache-ant-1.9.6/lib/ -f /~/git/TProg/EstacionDeTrabajo -Dnb.internal.action.name=rebuild clean jar
ant -lib ~/apache-ant-1.9.6/lib/ -f /~/git/TProg/WebApp -Dnb.internal.action.name=rebuild -DforceRedeploy=false -Dbrowser.context=/~/git/TProg/WebApp clean dist
