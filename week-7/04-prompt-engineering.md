# Lecture Plan

1. prompt engineering
 - prompt template
 - prompting guidelines
 - constraints
 - zero shot
 - few shot
 - Chian of thought
 - security considerations
 - hallucinations

---

# Prompt Engineering

**Prompt:** input provided to the LLM

**Prompt Engineering:** The process of designing and optimizing prompts to generate specific output from LLMs.

- Prompt engineering is impprtant to get accurate, relevant and reliable content from LLMs.



**Prompt Template**
- instructions (system message)
- context or additional info
- input (user message)
- output indicator

```
<system>
Generate a code snippet based on the context below. Ensure the code is optimized, well-commented, and follows best practices. 
If the requirements are unclear or if you’re unsure about the implementation, indicate that you need more information.
</system>

###

Context: 
The task is to create an advanced Java servlet that demonstrates the use of servlet filters to log request and response details. The servlet should handle HTTP GET requests and should include proper logging of request parameters and response status. Additionally, ensure that the servlet uses a filter for logging purposes and includes error handling for any potential issues.

###

<user>
Write a Java servlet with a servlet filter that logs request and response details. The servlet should handle HTTP GET requests and include error handling. 
</user>

###

{Answer in Java}

```

## Prompt Guidelines

- Include details in the prompt
- ask model to adopt a persona (Act as).
- use delimiters to clearly indicate the parts of prompt
- use delimiters  like ```, """, <>, <tag></tag>, :
- specify the steps required to complete the task (chain of thought)
- Few Shot Prompting (providing examples)
- specify desired length and structure of output (200 tokens or a paragraph or 10 line)
- reference text for additional context
- iterate

## Paramaters


- **n:** Number of completions to generate for the given prompt. Helps in getting multiple responses for comparison.

- **max_tokens:** Maximum number of tokens (words or pieces of words) in the generated response. Limits the length of the output.

- **stop:** Specifies one or more sequences where the model should stop generating further text. Useful for controlling the endpoint of the output.

- **response_format:** Format in which the response is returned (plain text or JSON). Determines how the output is structured.

- **temperature:** Controls the randomness of the response. A higher value generates more creative or diverse responses and a lower value (0.0) makes the output more focused and deterministic.

- **top_p:** Probability mass for nucleus sampling. It sets a probability threshold to choose words for generating responses. It helps balance diversity and coherence by considering only the most likely words until their combined probability reaches the specified threshold.



## Security consideration

1. Prompt Injection
2. Model Theft
3. Access to Sensitive Information

[refer OWASP LLM Security considerations](https://owasp.org/www-project-top-10-for-large-language-model-applications/))

## Hallucinations
- LLM generating factually incorrect or nonsensical information is called Hallucination.
- It is the misalignmnet of text generation objectve and user's objective of desired responses.

**NLP hallucination types:**
- intrinsic: input info is manupulated
- extrinsic: info not in input is added


**Sources of hallucinations**

- **Imperfect Representation Learning:** Inadequate understanding or encoding of input data by the model, leading to incorrect or incomplete outputs.

- **Erroneous Decoding:** Mistakes made during the process of generating text from the model’s internal representation, resulting in incorrect or nonsensical output.

- **Exposure Bias:** The model generates output based on patterns seen during training which can lead to poor performance on less frequent or new inputs.

- **Parametric Knowledge Bias:** The model’s internal parameters and training data may reflect biases cuasing the generation of outputs that reinforce or reflect these biases.


**LLM Hallucinations Types:**

- Factuality Hallucination
    - Factual Inconsistency
    - Factual Fabrication
    - Faithfulness Hallucination
- Instruction Inconsistency
    - Context Inconsistency
    - logical Inconsistency

[refer a survey of LLM hallucinations](https://arxiv.org/pdf/2311.05232)