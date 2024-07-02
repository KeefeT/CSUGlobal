#include <iostream>
#include <vector>
#include <glad/glad.h>
#include <GLFW/glfw3.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>


using namespace std;

void framebuffer_size_cb(GLFWwindow *p_window, int width, int height);
void processInput(GLFWwindow *p_window);
unsigned int createVertexShader();
unsigned int createFragmentShader();
unsigned int createShaders();
void drawTris(glm::vec2 A, glm::vec2 B, glm::vec2 C, int n, std::vector<float>& vertices);
void drawTri(glm::vec2 A, glm::vec2 B, glm::vec2 C, std::vector<float>& vertex_arr);
glm::vec2 mid(glm::vec2 A, glm::vec2 B);

const unsigned int INIT_WIDTH = 800;
const unsigned int INIT_HEIGHT = 600;

const char *vertexShaderSrc =
"#version 330 core\n"
"layout (location = 0) in vec3 aPos;\n"
"void main()\n"
"{\n"
"	glPosition = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n"
"}\0";

const char *fragmentShaderSrc =
"#version 330 core\n"
"out vec4 FragColor;\n"
"void main()\n"
"{\n"
"	FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n"
"}\n\0";

int main() {

	//init glfw
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	GLFWwindow* p_window = glfwCreateWindow(INIT_WIDTH, INIT_HEIGHT, "Serpinski", NULL, NULL);

	if (NULL == p_window) 
	{
		std::cout << "error, p_window is null" << std::endl;
		glfwTerminate();
		return -1;
	}
	else
	{
		glfwMakeContextCurrent(p_window);
		glfwSetFramebufferSizeCallback(p_window, framebuffer_size_cb);

		//load OpenGL function pointers
		if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress))
		{
			std::cout << "failed to get glfw process address" << std::endl;
			return -1;
		}

		//opengl crap
		unsigned int shaders = createShaders();
		unsigned int VBO, VAO;
		glGenVertexArrays(1, &VAO);
		glGenBuffers(1, &VBO);
		glBindVertexArray(VAO);
		glBindBuffer(GL_ARRAY_BUFFER, VBO);
		glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)0);
		glEnableVertexAttribArray(0);
		glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)(3 * sizeof(float)));
		glEnableVertexAttribArray(1);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glClearColor(0.2f, 0.3f, 0.3f, 1.0f);


		std::vector<float> vertices;
		glm::vec2 pA(0.0f, 0.5f), pB(0.5f, -0.5f), pC(-0.5f, -0.5f); 
		drawTris(pA, pB, pC, 5, vertices);

		glBindVertexArray(VAO);
		glBindBuffer(GL_ARRAY_BUFFER, VBO);
		glBufferData(GL_ARRAY_BUFFER, vertices.size() * sizeof(float), &vertices[0], GL_STATIC_DRAW);

		//main rendering loop
		while (false == glfwWindowShouldClose(p_window))
		{
			//check input
			processInput(p_window);
			
			//render
			glClear(GL_COLOR_BUFFER_BIT);

			//draw triangle
			glUseProgram(shaders);
			glBindVertexArray(VAO);
			glDrawArrays(GL_TRIANGLES, 0, vertices.size());

			//swap buffers, poll I/O events
			glfwSwapBuffers(p_window);
			glfwPollEvents();
		}
	}


	glfwTerminate();
	return 0;
}


//window resize cb
void framebuffer_size_cb(GLFWwindow* p_window, int width, int height)
{
	glViewport(0, 0, width, height);
}

//process input func, close window on `esc` press
void processInput(GLFWwindow* p_window)
{
	if (glfwGetKey(p_window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
	{
		glfwSetWindowShouldClose(p_window, true);
	}
}

unsigned int createVertexShader()
{
	int success;
	char errorLog[512];

	//create vertex shader
	unsigned int vtxShader = glCreateShader(GL_VERTEX_SHADER);
	glShaderSource(vtxShader, 1, &vertexShaderSrc, NULL);
	glCompileShader(vtxShader);
	glGetShaderiv(vtxShader, GL_COMPILE_STATUS, &success);

	if (0 != success)
	{
		glGetShaderInfoLog(vtxShader, 512, NULL, errorLog);
		std::cout << "ERROR: cannot compile vertex shader: " << errorLog << std::endl;
	}
	else
	{
		return vtxShader;
	}
}

unsigned int createFragmentShader()
{
	int success;
	char errorLog[512];

	//create fragment shader
	unsigned int frgShader = glCreateShader(GL_FRAGMENT_SHADER);
	glShaderSource(frgShader, 1, &fragmentShaderSrc, NULL);
	glCompileShader(frgShader);
	glGetShaderiv(frgShader, GL_COMPILE_STATUS, &success);

	if (0 != success)
	{
		glGetShaderInfoLog(frgShader, 512, NULL, errorLog);
		std::cout << "ERROR: cannot compile fragment shader: " << errorLog << std::endl;
	}
	else
	{
		return frgShader;
	}
}

unsigned int createShaders()
{
	int success;
	char errorLog[512];
	unsigned int vtx = createVertexShader();
	unsigned int frg = createFragmentShader();
	unsigned int shader = glCreateProgram();

	glAttachShader(shader, vtx);
	glAttachShader(shader, frg);
	glLinkProgram(shader);

	glGetProgramiv(shader, GL_LINK_STATUS, &success);
	if (0 != success)
	{
		glGetShaderInfoLog(shader, 512, NULL, errorLog);
		std::cout << "ERROR: linking shaders failed: " << errorLog << std::endl;
	}
	else
	{
		glDeleteShader(vtx);
		glDeleteShader(frg);
		return shader;
	}
}

void drawTri(glm::vec2 A, glm::vec2 B, glm::vec2 C, std::vector<float>& vertex_arr)
{
	float tri[] = {
		// positions    
		 A.x, A.y, 0.0f, 1.f, 0.5f, 0.0f,
		 B.x, B.y, 0.0f, 1.f, 0.5f, 0.0f,
		 C.x, C.y, 0.0f, 1.f, 0.5f, 0.0f,
	};
	for (int i = 0; i < 18; i++) {
		vertex_arr.push_back(tri[i]);
	}

}

void drawTris(glm::vec2 A, glm::vec2 B, glm::vec2 C, int n, std::vector<float>& vertices) {
	// Sierpinski's Algorithm
	drawTri(mid(A, B), mid(B, C), mid(A, C), vertices);
	if (n > 0) {
		drawTris(A, mid(A, B), mid(A, C), n - 1, vertices);
		drawTris(B, mid(A, B), mid(B, C), n - 1, vertices);
		drawTris(C, mid(A, C), mid(B, C), n - 1, vertices);
	}
}

glm::vec2 mid(glm::vec2 A, glm::vec2 B)
{
	float x = (A.x + B.x) / 2;
	float y = (A.y + B.y) / 2;
	return glm::vec2(x, y);
}
