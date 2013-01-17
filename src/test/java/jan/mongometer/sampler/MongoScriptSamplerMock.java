package jan.mongometer.sampler;

import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;

/**
 * User: jan
 */
public class MongoScriptSamplerMock
    extends MongoScriptSampler {

    public MongoScriptSamplerMock() {
    }

    @Override
    public SampleResult sample(Entry e) {

        SampleResult res = new SampleResult();
        String data = getScript();
        String response = Thread.currentThread().getName();

        try {
            MongoScriptRunnerMock runner = new MongoScriptRunnerMock();

            res.setSampleLabel(getTitle());
            res.setResponseCodeOK();
            res.setResponseCode("200");
            res.setSuccessful(true);
            res.setResponseMessage("OK");// $NON-NLS-1$
            res.setResponseMessageOK();
            res.sampleStart();

            res.setSamplerData(data);
            res.setDataType(SampleResult.TEXT);
            res.setContentType("text/plain"); // $NON-NLS-1$

            res.setResponseData(runner.evaluate(null, data).getBytes());
        }
        catch (Exception ex) {
            res.setResponseCode("500");// $NON-NLS-1$
            res.setSuccessful(false);
            res.setResponseMessage(ex.toString());
            res.setResponseData(ex.getMessage().getBytes());
        }
        finally {
            res.sampleEnd();
        }

        return res;
    }

}
