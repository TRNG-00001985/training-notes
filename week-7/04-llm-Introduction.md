# Lecture Plan

- AI, ML and Gen AI Introduction
- LLMs
---

**Artificial Intelligence**
Development of computer systems to perform tasks that require human Intelligence. Logical resoning, NLP, Problem solving.

**Machine Learning**
Subset of AI focusing on developing models that enable computers to learn from data without explicit programming.
**ML Model:**
- data prep
- train
- evaluate

- The models performce is directly proportinal to the quality of training data and duration of training.

**Types of learning:**

- Supervised Learning
- Unsupervised Learning
  - Self Supervised Learning
- Semi Supervised Learning

**Generative AI**
Gen AI, generates text, images, videos, code, speech and other media.

# LLM

- LLMs are Langauge models that are trained to generate the next words or tokens, given some input text.
- Natural Language Processing (NLP): Natural Language Underatanding (NLU) + Natural Lnaguage Generation (NLG).

**Self-Supervised Learning**

- LLMs are trained using a technique called self-supervised learning. This method involves the model teaching itself by predicting parts of the input data based on other parts.
- If a word is missing from a sentence, the model predicts what that word should be. 
- The power of self-supervised learning lies in its ability to use the data itself to generate labels.

**Transfer Learning**

- Transfer learning is a key concept in LLMs. It involves taking a model pre-trained on one task and fine-tuning it for another related task. 
- For LLMs, the process begins with pre-training on a massive corpus of text to learn general language patterns using self-supervised learning. 
- The model becomes proficient at tasks like predicting the next word in a sentence.
- After pre-training, the model is fine-tuned on a specific dataset related to the target task, such as sentiment analysis or question answering. 
- Transfer learning allows the model to apply its general knowledge to new tasks, even when limited task-specific data is available.

**Attention Mechanism: "Attention Is All You Need"**

- The [Attention Is All You Need](https://arxiv.org/abs/1706.03762) paper is published in 2017. It introduces the Transformer model, which forms the foundation of most modern LLMs. 
- The key innovation here is the attention mechanism, which allows the model to focus on different parts of the input text when making predictions.
- Unlike older models that process text sequentially, transformers use attention to consider all input words simultaneously, allowing the model to take the entire context of a sentence into account when predicting the next word. This leads to much more accurate and coherent text generation.

**Encoder, Decoder, and Encoder-Decoder Architectures**

Transformers can be broken down into three main architectures: 

1. **Encoder:** 
   
- The encoder architecture is designed to process the entire input sequence at once and capturing contextual information from all the words in the input.
-  BERT (Bidirectional Encoder Representations from Transformers) is a prime example of an encoder model. 
- BERT is excellent for tasks like text classification and named entity recognition.

1. **Decoder:** 

- The decoder architecture, on the other hand, focuses on generating output sequences one word at a time, using previously generated words to predict the next one. 
- GPT (Generative Pre-trained Transformer) is an example of a decoder model. GPT is unidirectional. It generates text by predicting the next word based on the previous words in the sequence. 
- GPT is particularly strong in tasks like text generation.

3. **Encoder-Decoder:** 

- The encoder-decoder architecture combines both approaches. 
- The encoder processes the input sequence to create a context representation, which the decoder then uses to generate the output sequence. 
- This architecture is commonly used in tasks like machine translation and summarization.

**Referece:**

1. [hugging face NLP](https://huggingface.co/learn/nlp-course/en/chapter1/1?fw=pt)


### Examples for LLMs
- **Open AI:** GPT 2, 3, 3.5 turbo and 4, 4o
- **Antropic:** Claude 1, 2, 3 and 3.5.
- **Google:** PaLM text-bision, chat-bision, gemini, gemma
- **Meta:** LLama, LLama 2, llama 3
- **gork**
- **Mistral AI**

**Note**
- GPT 40, Gemini Pro, Claude 3 and 3.5 are multi models.

**The following tool and llms are good for Code Generation**

- Github Copilot
- Codium
- Black Box
- Gpt 4o
- Claude 3.5
- Gemini Pro