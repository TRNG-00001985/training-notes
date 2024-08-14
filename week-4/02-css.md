# Lecture/Guided Coding Example

1. CSS

---

# CSS

Cascading Style Sheets (CSS) is a style sheet language used to describe the presentation of HTML or XML. CSS describes how elements should be rendered on screen.


css ruleset

```css
selector {
    property: value;  /* decleration */
}
```

**selector:** it defines the element(s) to be styled.
**decleration:** a single rule. specifies which property is being styled.


### Inline, Internal  and External Sheets

**inline:** CSS styles applied directly to an HTML element using the `style` attribute within the opening tag.

```css
<p style="color: blue; font-size: 16px;">This is an inline-styled paragraph.</p>
```

**internal:** CSS rules defined within a `<style>` block in the `<head>` section of an HTML document.


```css
<style>
  p {
    color: blue;
    font-size: 16px;
  }
</style>
```

**external:** CSS rules contained in a separate `.css` file, linked to the HTML document using the `<link>` tag.


```css
p {
  color: blue;
  font-size: 16px;
}
```

```html
<head>
<link rel="stylesheet" href="styles.css">
<head>
```

**why use external style sheets?**

- seperation of content (HTML) from the rules (css styling).
- all web pages can share the same stylesheet
- one the stylesheet is  downloaded by the user the rest of the site will be loaded faster.
- one place to modify the page styling

### Properties

#### Color

**RGB** :red, green, blue  (0-255)

```css
p {
    color: rgb(100,100,100);
}
```

**RGBA (Red, Green, Blue, Alpha):**

red, green, blue, alpha (0-1). alpha defines the transparancy.

```css
p {
    color: rgba(255, 0, 0, 0.5); /* Semi-transparent red */
}
```

**HSL (Hue, Saturation, Lightness):**

- **Hue:** degree on the color wheel (0-360).
- **Saturation:** percentage (0% means a shade of gray, 100% is full color).
- **Lightness:** percentage (0% is black, 100% is white).

```css
p {
    color: hsl(120, 100%, 50%); /* A shade of green */
}
```

**HEX codes:** 6 digits that represent the ammount of red, green and blue color. (0-f)

```css
p {
    color: #000000;
}
```

**color names** predefined color names recognised by the browser.



### Font

**Font Family:** Specifies the typeface to be used for the text.

```css
p {
    font-family: Arial, sans-serif;
}
```

**Font Size:** Defines the size of the font.

```css
p {
    font-size: 16px;
}
```

**Font Weight:** Controls the thickness of the font.

```css
p {
    font-weight: bold;
}
```

**Font Style:** Sets the style of the font (e.g., italic, normal).

```css
p {
    font-style: italic;
}
```

---

### Text

**Text Align:** Controls the alignment of the text within an element.

```css
p {
    text-align: center;
}
```

**Text Decoration:** Adds decoration to text, such as underline, overline, or line-through.

```css
p {
    text-decoration: underline;
}
```

**Text Transform:** Changes the capitalization of text (e.g., uppercase, lowercase).

```css
p {
    text-transform: uppercase;
}
```

**Letter Spacing:** Controls the space between characters.

```css
p {
    letter-spacing: 2px;
}
```

**Line Height:** Sets the height of a line of text.

```css
p {
    line-height: 1.5;
}
```

---

### Box

**Padding:** Controls the space inside the element, between the content and the border.

```css
div {
    padding: 20px;
}
```

**Margin:** Sets the space outside the element, between the element's border and surrounding elements.

```css
div {
    margin: 20px;
}
```

**Border:** Defines the border around an element.

```css
div {
    border: 2px solid black;
}
```

**Width & Height:** Sets the width and height of an element.

```css
div {
    width: 100px;
    height: 100px;
}
```

**Box Shadow:** Adds a shadow effect around an element.

```css
div {
    box-shadow: 5px 5px 10px #888888;
}
```

---

### Layout

**Display:** Defines how an element is displayed on the page (e.g., block, inline, flex).

```css
div {
    display: flex;
}
```

**Position:** Controls the positioning method of an element (e.g., relative, absolute, fixed).

```css
div {
    position: absolute;
    top: 50px;
    left: 50px;
}
```

**Flexbox:** A layout model that allows you to align elements in a container.

```css
.container {
    display: flex;
    justify-content: center;
    align-items: center;
}
```

**Grid:** A layout system for creating complex grid-based designs.

```css
.container {
    display: grid;
    grid-template-columns: 1fr 2fr;
}
```

**Float:** Allows elements to float to the left or right, wrapping text around them.

```css
img {
    float: left;
    margin-right: 20px;
}
```

--- 

These notes cover the essentials for working with fonts, text, box models, and layout in CSS.

## Selectors

**universal selector:** applied to all elements in the docuemnt

```css
* {
        /* decleration */
}
```

**element selector:** All HTML elements of the specified type

```css
p {
    /* decleration */
}
```

**id selector:** the element on the page with the specified id. On HTML page, each id value should be unique.

```css
#myid {
    /* decleration */

}
```

**class selector:** the element(s) on the page with the specified class. Multiple instances of the same class can appear on a page.

```css
.myclass {
        /* decleration */
}
```

**attribute selector:** the element(s) on the page with the specified attribute.

```css
img[src] {
    /* decleration */
}
```

**child selector:** matches an element that is direct child of another

```css
li>a {
    /* decleration */
}
```

**descendant selector:** matches an element that is a decendent of another specified element. 

```css
p a {
    /* decleration */
}
```

**adjacent sibling:** matches a preceeding element (adjacent sibling)

```css
h1 + p{
    /* decleration */
}
```

**general sibling:** matches a sibling element

```css

h1~p{
    /* decleration */
}
```

**pseudo-classes:** the specified element(s), but only when in the specified state.

```css
a:hover {
    /* decleration */
}
```
### Cascading nature of CSS

- if two are more rules apply to an element it is important to understand which will take precedence.

**Last Rule:** is two selectors are identical the later of two takes precedence

**Specificity:** the most specific selector will take precedence over others.

**Important:** `!importnat` after any property value marks that a rule is more important than others.


### CSS Box Model

CSS is all about boxes. Most HTML elements on the page can be thought as boxed placed on top of other boxes.

each box takes up some space on the page and has the properties:

**padding:** the space around the context

**border:** the solid line that is just outside the padding

**margin:** the space around the outside of border


### Responsive Web Design

the web design approach that makes web pages render well on a variety of devices and window or screen sizes.

1. percentages instead of pixels
2. flexible media
3. media queries

```css
@media only screen and (max-width: 480px) {
  /* Styles for mobile */
  .container {
    width: 70%;
  }
}
```

### CSS Flex

**CSS Flexbox** (Flexible Box Layout) is a layout model that allows you to design complex layouts easily and align items in a container. It is particularly useful for creating responsive web designs where the layout needs to adjust based on the screen size.

#### Key Concepts:
- **Flex Container:** The parent element where the `display: flex;` property is applied.
- **Flex Items:** The child elements within the flex container that will be laid out according to the flex properties.

#### Basic Example:
```css
.container {
    display: flex;
    justify-content: center; /* Center items horizontally */
    align-items: center; /* Center items vertically */
    flex-direction: row; /* Arrange items in a row (default) */
}

.item {
    flex: 1; /* All items take equal space */
}
```

#### Main Properties:

1. **display: flex;**
   - Converts a container into a flexbox container, making its children flex items.

2. **flex-direction:**
   - Determines the direction of the flex items.
   - Values: `row`, `row-reverse`, `column`, `column-reverse`.

3. **justify-content:**
   - Controls the horizontal alignment of flex items.
   - Values: `flex-start`, `flex-end`, `center`, `space-between`, `space-around`.

4. **align-items:**
   - Controls the vertical alignment of flex items.
   - Values: `stretch` (default), `flex-start`, `flex-end`, `center`, `baseline`.

5. **flex-wrap:**
   - Controls whether flex items should wrap onto multiple lines if they overflow.
   - Values: `nowrap` (default), `wrap`, `wrap-reverse`.

6. **flex-grow, flex-shrink, flex-basis:**
   - `flex-grow`: Defines how much a flex item will grow relative to the others.
   - `flex-shrink`: Defines how much a flex item will shrink relative to the others.
   - `flex-basis`: Sets the initial size of a flex item before space is distributed.

7. **align-self:**
   - Allows individual flex items to override the `align-items` value.
   - Values: `auto`, `flex-start`, `flex-end`, `center`, `baseline`, `stretch`.

#### Example Layout:
```css
.container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
}

.item {
    flex: 1;
    padding: 10px;
}
```

This would create a horizontal layout with equally spaced items, centered vertically.

### CSS Grid

**CSS Grid Layout** is a two-dimensional layout system that allows you to create complex web designs with rows and columns. It provides more control and flexibility than flexbox when designing layouts that require precise control over both rows and columns.

#### Key Concepts:
- **Grid Container:** The parent element where the `display: grid;` property is applied.
- **Grid Items:** The child elements within the grid container.

####  Example:
```css
.container {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr; /* Defines three columns with different widths */
    grid-template-rows: auto; /* Defines rows, auto adjusts to content */
    gap: 10px; /* Space between grid items */
}

.item {
    background-color: lightblue;
    padding: 20px;
}
```

#### Main Properties:

1. **display: grid;**
   - Converts a container into a grid container.

2. **grid-template-columns:**
   - Defines the number of columns and their widths.
   - Example: `grid-template-columns: 1fr 2fr 1fr;` creates three columns.

3. **grid-template-rows:**
   - Defines the number of rows and their heights.
   - Example: `grid-template-rows: 100px 200px;` creates two rows.

4. **grid-column / grid-row:**
   - Controls the placement of individual grid items.
   - Example: `grid-column: 1 / 3;` spans the item from the first column to the third.

5. **grid-area:**
   - Allows you to define both the starting and ending position of an item in both the rows and columns.
   - Example: `grid-area: 1 / 1 / 2 / 3;` places an item starting from the first row/column to the second row and third column.

6. **gap:**
   - Defines the spacing between rows and columns.
   - Example: `gap: 10px;` sets 10px spacing between all rows and columns.

7. **justify-items / align-items:**
   - Controls the alignment of grid items within their grid area.
   - Values: `start`, `end`, `center`, `stretch`.

8. **grid-auto-flow:**
   - Controls how auto-placed items are laid out.
   - Values: `row` (default), `column`, `dense`, `row dense`, `column dense`.

#### Example :
```css
.container {
    display: grid;
    grid-template-columns: repeat(3, 1fr); /* Three equal columns */
    grid-template-rows: 200px auto; /* Two rows, with the second adjusting to content */
    gap: 15px;
}

.item {
    background-color: lightcoral;
}
```


### CSS Variables

custom properties, that allow you to define the reusable values.

```css
:root {
    --var-name : value;
}

element {
    property: var(--var-name);
}
```

